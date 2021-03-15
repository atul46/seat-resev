package com.superops.tickets.service;

import com.superops.tickets.model.dto.BookTicketsDto;
import com.superops.tickets.model.dto.TheatreDetailDto;
import com.superops.tickets.model.entity.Movie;




public interface TicketBookingService {

//    public TheatreDetailDto getAllMovies();
//
//    public Movie getTicketDetails(String movieId);

    public Movie bookTicket(BookTicketsDto bookTicketsDto);
}
