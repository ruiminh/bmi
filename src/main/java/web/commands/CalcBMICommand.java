package web.commands;

import business.exceptions.UserException;
import business.services.BmiUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcBMICommand extends CommandUnprotectedPage{
    public CalcBMICommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        double height= 0.0;
        double weight =0.0;
        double bmi =0.0;
        String category = "";

        try
        {
        height=Double.parseDouble(request.getParameter("height"));
        weight=Double.parseDouble(request.getParameter("weight"));
        }
        catch (NumberFormatException ex)
        {
            request.setAttribute("error","remember to input two integers!");
            return "index";
         //throw new UserException("remember to input integer");
        }

        bmi=BmiUtil.calcBMI(height,weight);

        category= BmiUtil.getCategory(bmi) ;

        request.setAttribute("bmi",String.format("%.2f",bmi));
        request.setAttribute("height",height);
        request.setAttribute("weight",weight);
        request.setAttribute("category",category);


        return pageToShow;
    }
}
