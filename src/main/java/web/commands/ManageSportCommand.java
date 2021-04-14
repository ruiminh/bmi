package web.commands;

import business.entities.Sport;
import business.exceptions.UserException;
import business.services.BmiFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageSportCommand extends CommandProtectedPage
{
    BmiFacade bmiFacade;
    public ManageSportCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
        this.bmiFacade=new BmiFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String deleteId=request.getParameter("delete");
        String editId=request.getParameter("edit");
        String update=request.getParameter("update");

        if(deleteId !=null)
        {
            int rowsAffected=bmiFacade.deleteSport(Integer.parseInt(deleteId));

            if(rowsAffected>0)
            {
                request.getServletContext().setAttribute("sportList",bmiFacade.getAllSports());
            }else
                {
                    request.setAttribute("error","You cannot delete this sport");

                }

        }else if(editId !=null)
        {
            Sport sport = bmiFacade.getSportsById(Integer.parseInt(editId));
            request.setAttribute("sportItem",sport);
            return "editsportpage";

        }else if(update !=null)
        {
            //update sport in datebase
            String name=request.getParameter("name");
            String sportId =request.getParameter(("sports_id"));
            int rowsUpdated = bmiFacade.updateSport(Integer.parseInt(sportId),name);
            if(rowsUpdated==1)
            {
                //update application state
                request.getServletContext().setAttribute("sportList",bmiFacade.getAllSports());
            }
        }

        return pageToShow;
    }
}
