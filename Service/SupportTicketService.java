package Service;

import java.util.Optional;
import java.util.List;

import Controller.dto.AdminDto;
import Controller.dto.StudentDto;
import Controller.dto.SupportTicketDto;
import Exception.BusinessException;
import Repository.SupportTicketRepositoy;
import Model.Support.SupportTicket;
import Model.User.Admin;
import Model.User.Student;
import Util.GenericCsvExporter;

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

    public Optional<SupportTicketDto> findNextTicketInQueue() {
        Optional<SupportTicket> ticketOptional = supportTicketRepositoy.peekTicket();

        return ticketOptional.map(ticket -> {
            SupportTicketDto dto = new SupportTicketDto();
            dto.setTitle(ticket.getTitle());
            dto.setMessage(ticket.getMessage());
            if (ticket.getAuthor() instanceof Student) {
                StudentDto studentDto = new StudentDto(ticket.getAuthor().getName(), ticket.getAuthor().getEmail());
                dto.setAuthor(studentDto);
            } else {
                dto.setAuthor(new AdminDto(ticket.getAuthor().getName(), ticket.getAuthor().getEmail()));
            }
            return dto;
        });
    }

    public Optional<SupportTicketDto> resolveNextTicketInQueue() {
        Optional<SupportTicket> ticketOptional = supportTicketRepositoy.resolveTicket();

        return ticketOptional.map(ticket -> {
            SupportTicketDto dto = new SupportTicketDto();;
            dto.setTitle(ticket.getTitle());
            dto.setMessage(ticket.getMessage());
            if (ticket.getAuthor() instanceof Student) {
                dto.setAuthor(new StudentDto(ticket.getAuthor().getName()));
            } else {
                dto.setAuthor(new AdminDto(ticket.getAuthor().getName(), ticket.getAuthor().getEmail()));
            }
            return dto;
        });
    }

    public void exportAllSupportTickets(List<String> fieldsToInclude) {
        List<SupportTicket> supportTickets = supportTicketRepositoy.exportAllSupportTickets();
        String csv = GenericCsvExporter.export(supportTickets, fieldsToInclude);
        System.out.println(csv);
        
    }

    
}
