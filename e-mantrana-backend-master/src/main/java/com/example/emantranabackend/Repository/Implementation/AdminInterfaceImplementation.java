package com.example.emantranabackend.Repository.Implementation;

import com.example.emantranabackend.DTO.DoctorRegistrationRequestDTO;
import com.example.emantranabackend.DTO.TimeTableDTO;
import com.example.emantranabackend.Model.Doctor;
import com.example.emantranabackend.Model.TimeTable;
import com.example.emantranabackend.Repository.AdminInterface;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.print.Doc;
import java.sql.Time;
import java.util.List;

@Repository("admin1")
public class AdminInterfaceImplementation implements AdminInterface {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean addDoctor(DoctorRegistrationRequestDTO doctor){
        Session currentSession=entityManager.unwrap(Session.class);
        String password="abcd11$";
        Doctor doc=new Doctor(doctor.getFname(), doctor.getLname(), password,
                doctor.getType(), doctor.getEmail(), doctor.getPh_number(),
                0);
        currentSession.persist(doc);
        entityManager.clear();
        Query q=currentSession.createQuery("from Doctor d where d.email=:email");
        q.setParameter("email", doctor.getEmail());
        doc=(Doctor) q.list().get(0);
        entityManager.clear();

        List<TimeTableDTO> list=doctor.getTimeTable();
        for(Object o:list){
            TimeTableDTO timeTableDTO=(TimeTableDTO) o;
            java.sql.Time tin=new java.sql.Time(timeTableDTO.getTime_in()*1000-(5*3600+30*60)*1000);
            java.sql.Time tout=new java.sql.Time(timeTableDTO.getTime_out()*1000-(5*3600+30*60)*1000);
            TimeTable timeTable=new TimeTable(timeTableDTO.getDay(),
                    tin,
                    tout,
                    doc);
            currentSession.persist(timeTable);
            entityManager.clear();
        }
        return true;
    }
}
