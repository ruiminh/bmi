package business.persistence;

import business.entities.BmiEntry;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BmiMapper {
    private Database database;

    public BmiMapper(Database database) {
        this.database = database;
    }

    public List<BmiEntry> getBmiDataEntriesByUserId(int userId) throws UserException {

        List<BmiEntry> bmiEntryList = new ArrayList<>();

        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM bmi_entry WHERE user_id=?;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1,userId);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt("bmi_entry_id");
                    int height = rs.getInt("height");
                    int weight = rs.getInt("weight");
                    String category = rs.getString("category");
                    double bmi = rs.getDouble("bmi");
                    String gender = rs.getString("gender");
                    Timestamp ts = rs.getTimestamp("created");


                    bmiEntryList.add(new BmiEntry(id, height, weight, category, bmi, gender, ts));
                    //todo:Excute mothed to add
                    //Sport,hobby,user


                }
                return bmiEntryList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }


    }

    public List<BmiEntry> getAllBmiDataEntries() throws UserException {
        List<BmiEntry> bmiEntryList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM bmi_entry;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt("bmi_entry_id");
                    int height = rs.getInt("height");
                    int weight = rs.getInt("weight");
                    String category = rs.getString("category");
                    double bmi = rs.getDouble("bmi");
                    String gender = rs.getString("gender");
                    Timestamp ts = rs.getTimestamp("created");


                    bmiEntryList.add(new BmiEntry(id, height, weight, category, bmi, gender, ts));
                    //todo:Excute mothed to add
                    //Sport,hobby,user


                }
                return bmiEntryList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }


    }
    public void insertBmiEntry(
            double bmi,
            double height,
            double weight,
            String category,
            String gender,
            int sport_id,
            int user_id,
            List<Integer> hobbyList)throws UserException {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `bmi`.`bmi_entry` "+
            "(`height`,"+
             "`weight`,"+
             "`category`,"+
             "`bmi`,"+
             "`gender`,"+
             "`sport_id`,"+
             "`user_id`) "+
             " VALUES (?,?,?,?,?,?,?);";


            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setDouble(1, height);
                ps.setDouble(2, weight);
                ps.setString(3, category);
                ps.setDouble(4, bmi);
                ps.setString(5, gender);
                ps.setInt(6, sport_id);
                ps.setInt(7,user_id);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int bmiEntryId = ids.getInt(1);
                //todo: should insert hobby to link_hobby_bmi
                for (Integer hobbyId : hobbyList) {
                    insertIntoLinkHobbyBmiEntry(bmiEntryId,(int)hobbyId);
                    
                }

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }

    }

    public void insertIntoLinkHobbyBmiEntry(int bmiEntryId,int hobbyId)throws UserException{
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `bmi`.`link_bmi_hobby` "+
                    "(`hobby_id`,"+
                    "`bmi_entry_id`) "+
                    " VALUES (?,?);";


            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, hobbyId);
                ps.setInt(2, bmiEntryId);

                ps.executeUpdate();


            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }



    }
}
