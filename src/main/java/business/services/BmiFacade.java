package business.services;

import business.entities.BmiEntry;
import business.exceptions.UserException;
import business.persistence.BmiMapper;
import business.persistence.Database;

import java.util.List;

public class BmiFacade
{
    private BmiMapper bmiMapper;

    public BmiFacade(Database database) {

        this.bmiMapper=new BmiMapper(database);
    }

    public List<BmiEntry> getBmiDataEntriesByUserId(int userId) throws UserException
    {
        return bmiMapper.getBmiDataEntriesByUserId(userId);
    }

    public List<BmiEntry> getAllBmiDataEntries() throws UserException
    {

        return bmiMapper.getAllBmiDataEntries();
    }


    public void insertBmiEntry(
            double bmi,
            double height,
            double weight,
            String category,
            String gender,
            int sport_id,
            int user_id,
            List<Integer> hobbyList
    )throws UserException
    {
        bmiMapper.insertBmiEntry(bmi,height,weight,category,gender,sport_id,user_id,hobbyList);

    }
}
