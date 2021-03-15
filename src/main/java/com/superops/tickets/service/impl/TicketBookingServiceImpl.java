package com.superops.tickets.service.impl;

import com.superops.tickets.model.dto.BookTicketsDto;
import com.superops.tickets.model.dto.TheatreDetailDto;
import com.superops.tickets.model.dto.TheatreDto;
import com.superops.tickets.model.entity.Movie;
import com.superops.tickets.model.entity.Theater;
import com.superops.tickets.payments.PaymentService;
import com.superops.tickets.repo.MovieTicketRepo;
import com.superops.tickets.repo.TheatreRepo;
import com.superops.tickets.service.TicketBookingService;
import net.bytebuddy.pool.TypePool;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;


import org.springframework.stereotype.Service;
import springfox.documentation.spi.service.contexts.SecurityContext;


import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.persistence.Version;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class TicketBookingServiceImpl implements TicketBookingService {

    @Autowired
    private  MovieTicketRepo movieTicketRepo;

    @Autowired
    private TheatreRepo theatreRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PaymentService paymentService;

//    @Override
//    public TheatreDetailDto getAllMovies() {
//        TheatreDetailDto theatreDetailDto=null;
//        try{
//            List<Theater> theatres=theatreRepo.findAll();
//            if(theatres.isEmpty()){
//                throw new RuntimeException("Data not found");
//            }
//            List<TheatreDto> theatreDtos=theatres.stream()
//                    .map(theater -> modelMapper.map(theater,TheatreDto.class))
//                    .collect(Collectors.toList());
//
//            theatreDetailDto=new TheatreDetailDto();
//            theatreDetailDto.setTheatreDetails(theatreDtos);
//
//
//        }catch(DataAccessException ex){
//            throw new RuntimeException("Error occured while fetching data "+ ex.getMessage());
//        }
//        return theatreDetailDto;
//    }
//
//
//    @Override
//    public MovieTicket getTicketDetails(String movieId) {
//        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//        MovieTicket movieTicket=
//        null;
//        try{
//            movieTicket= movieTicketRepo.findByMovieIdAndUserId(movieId,auth.getName());
//        }catch(DataAccessException ex){
//            throw new RuntimeException(String.format("Exception while fetching for movieId -%s",movieId));
//        }
//
//        return movieTicket;
//    }

    @Transactional
    @Version
    @Override
    public Movie bookTicket(BookTicketsDto bookTicketsDto) {

        Movie movieTicket=null;


        try{

            String result=paymentService.makePayment();
            if(result.equals("SUCCESS")){

                movieTicket=modelMapper.map(bookTicketsDto,Movie.class);
                movieTicketRepo.save(movieTicket);
            }


        }catch(DataAccessException | IOException ex){
              throw new RuntimeException("Exception while saving data");
        } catch(Exception e){
            throw new RuntimeException("EX");
        }

        return movieTicket;
    }
}
