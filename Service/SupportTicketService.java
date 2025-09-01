package Service;

import Controller.dto.StudentDto;
import Controller.dto.SupportTicketDto;
import Exception.BusinessException;
import Repository.SupportTicketRepositoy;
import Model.Support.SupportTicket;
import Model.User.User;
import Model.User.Admin;
import Model.User.Student;

public class SupportTicketService {
    
    private SupportTicketRepositoy supportTicketRepositoy;

    public SupportTicketService(SupportTicketRepositoy supportTicketRepositoy) {
        this.supportTicketRepositoy = supportTicketRepositoy;
    }



    public void saveSupportTicket(SupportTicketDto supportTicket) {
        SupportTicket modelSupportTicket = new SupportTicket(supportTicket.getTitle(), supportTicket.getMessage(), null);
        if(supportTicket.getTitle() == null || supportTicket.getMessage().isEmpty()) new BusinessException("Title and message are required.");

        if(supportTicket.getAuthor().getClass() == StudentDto.class){
            Student student = new Student(supportTicket.getAuthor().getName(), supportTicket.getAuthor().getEmail());
            modelSupportTicket.setAuthor(student);
        }else{
            Admin admin = new Admin(supportTicket.getAuthor().getName(), supportTicket.getAuthor().getEmail());
            modelSupportTicket.setAuthor(admin);
        }
        
        supportTicketRepositoy.saveSupportTicket(modelSupportTicket);

    }

    
}
