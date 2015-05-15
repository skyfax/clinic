package server.mappers;

import server.entities.Consultation;
import server.entities.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 02/05/2015.
 */
public class ConsultationMapper extends DatabaseAccess {

    private UserMapper userMapper = new UserMapper();

    public boolean insert(Consultation consultation) {

        String statement = "INSERT INTO consultation (patientId, doctorId, description, consultationDate, closed, hasArrive) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setInt(1, consultation.getPatient().getId());
            dbStatement.setInt(2, consultation.getDoctor().getId());
            dbStatement.setString(3, consultation.getDescription());
            dbStatement.setDate(4, consultation.getConsultationDate());
            dbStatement.setInt(5, consultation.getClosed());
            dbStatement.setInt(6, consultation.getHasArrived());
            dbStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void delete(Consultation consultation) {
        String statement = "DELETE FROM consultation WHERE (id)= (?)";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setLong(1, consultation.getId());
            dbStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consultation> findByCategory(Consultation consultation) {


        String statement = "SELECT * FROM consultation ";
        Boolean first = true;
        List<Consultation> consultationList = new ArrayList<Consultation>();
        int counter = 0;
        if (consultation.getId() != null || consultation.getPatient() != null || consultation.getDoctor() != null
                || consultation.getDescription() != null || consultation.getConsultationDate() != null
                || consultation.getClosed() != null || consultation.getHasArrived() != null) {
            statement = statement + " WHERE ";
            if (consultation.getId() != null) {
                statement = statement + " id = ?";
                first = false;
            }
            if (consultation.getPatient() != null) {
                if (first) {
                    statement = statement + " patientId = ?";
                    first = false;
                } else {
                    statement = statement + " AND patientId = ?";
                }
            }
            if (consultation.getDoctor() != null) {
                if (first) {
                    statement = statement + " doctorId = ?";
                    first = false;
                } else {
                    statement = statement + " AND doctorId = ?";
                }
            }
            if (consultation.getDescription() != null) {
                if (first) {
                    statement = statement + " description = ?";
                    first = false;
                } else {
                    statement = statement + " AND description = ?";
                }
            }
            if (consultation.getConsultationDate() != null) {
                if (first) {
                    statement = statement + " consultationDate = ?";
                    first = false;
                } else {
                    statement = statement + " AND consultationDate = ?";
                }
            }
            if (consultation.getClosed() != null) {
                if (first) {
                    statement = statement + " closed = ?";
                    first = false;
                } else {
                    statement = statement + " AND closed = ?";
                }
            }
            if (consultation.getHasArrived() != null) {
                if (first) {
                    statement = statement + " hasArrive = ?";
                    first = false;
                } else {
                    statement = statement + " AND hasArrive = ?";
                }
            }
        }
        statement = statement + ";";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            if (consultation.getId() != null) {
                dbStatement.setInt(++counter, consultation.getId());
            }
            if (consultation.getPatient() != null) {
                dbStatement.setInt(++counter, consultation.getPatient().getId());
            }
            if (consultation.getDoctor() != null) {
                dbStatement.setInt(++counter, consultation.getDoctor().getId());
            }
            if (consultation.getDescription() != null) {
                dbStatement.setString(++counter, consultation.getDescription());
            }
            if (consultation.getConsultationDate() != null) {
                dbStatement.setDate(++counter, consultation.getConsultationDate());
            }
            if (consultation.getClosed() != null) {
                dbStatement.setInt(++counter, consultation.getClosed());
            }
            if (consultation.getHasArrived() != null) {
                dbStatement.setInt(++counter, consultation.getHasArrived());
            }
            ResultSet rs = dbStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer patientId = rs.getInt("patientId");
                Integer doctorId = rs.getInt("doctorId");
                String description = rs.getString("description");
                Date consultationDate = rs.getDate("consultationDate");
                Integer closed = rs.getInt("closed");
                Integer hasArrive = rs.getInt("hasArrive");

                Consultation retConsultation = new Consultation();
                retConsultation.setId(id);

                User docPac= new User();
                docPac.setId(patientId);
                retConsultation.setPatient(userMapper.find(docPac));

                docPac.setId(doctorId);
                retConsultation.setDoctor(userMapper.find(docPac));
                retConsultation.setDescription(description);
                retConsultation.setConsultationDate(consultationDate);
                retConsultation.setClosed(closed);
                retConsultation.setHasArrived(hasArrive);
            }
            if (!consultationList.isEmpty()) {
                return consultationList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Consultation find(Consultation consultation) {
        return findByCategory(consultation).get(0);
    }

    public boolean update(Consultation consultation) {
        String statement = "UPDATE consultation SET patientId=?, doctorId=?, description=?, consultationDate=?, closed=?, hasArrive=? WHERE id = ?";
        try {
            PreparedStatement dbStatement = connection.prepareStatement(statement);
            dbStatement.setInt(1, consultation.getPatient().getId());
            dbStatement.setInt(2, consultation.getDoctor().getId());
            dbStatement.setString(3, consultation.getDescription());
            dbStatement.setDate(4, consultation.getConsultationDate());
            dbStatement.setInt(5, consultation.getClosed());
            dbStatement.setInt(6, consultation.getHasArrived());
            dbStatement.setLong(7, consultation.getId());
            dbStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
