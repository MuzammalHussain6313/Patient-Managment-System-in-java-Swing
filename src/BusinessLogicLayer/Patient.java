package BusinessLogicLayer;

import java.util.Date;

public class Patient
{
    private int id;
    private String name;
    private String fatherName;
    private String gender;
    private Date dateOfBirth;
    private String doctor;
    private String diseaseHistory;
    private String prescription;
    public Patient(int id,String name,String fatherName,String gender,Date dateOfBirth,String doctor,String diseaseHistory, String prescription)
    {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.doctor = doctor;
        this.diseaseHistory = diseaseHistory;
        this.prescription = prescription;
    }
    public int getid()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getFatherName()
    {
        return fatherName;
    }
    public String getGender()
    {
        return gender;
    }
    public Date getDateOfBirth()
    {
        java.sql.Date sqlDate = new java.sql.Date(dateOfBirth.getTime());
        return dateOfBirth;
    }
    public String getDoctorName()
    {
        return doctor;
    }
    public String getDiseaseHistory()
    {
        return diseaseHistory;
    }
    public String getPrescription()
    {
        return prescription;
    }
}
