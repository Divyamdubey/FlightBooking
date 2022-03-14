package com.services.FlightBooking.service.servicesImpl;

import com.services.FlightBooking.models.Booking;
import com.services.FlightBooking.models.Flight;
import com.services.FlightBooking.models.Passenger;
import com.services.FlightBooking.models.User;
import com.services.FlightBooking.repository.BookingRepository;
import com.services.FlightBooking.repository.FlightRepository;
import com.services.FlightBooking.repository.PassengerRepository;
import com.services.FlightBooking.repository.UserRepository;
import com.services.FlightBooking.service.PnrGenerator;
import com.services.FlightBooking.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PnrGenerator pnrGenerator;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> search(String flightDeparture,String flightArrival){
        return flightRepository.findByDeparture(flightDeparture,flightArrival);
    }

    public Optional<Booking> userBookFlight(String flightNo,Passenger passenger){
        System.out.println("FlightId"+" "+flightNo);
        System.out.println("Passenger"+" "+passenger.getBookingMail());
        System.out.println("Passenger"+" "+passenger.getFirstName()+" "+passenger.getLastName()+" "+
                passenger.getGender()+" "+passenger.getAge()+" "+passenger.getPnr()+" "+passenger.getId());
        Optional<Flight> checkFlight= Optional.ofNullable(flightRepository.findByFlightNo(flightNo));
        System.out.println(checkFlight.isPresent());
        if (!checkFlight.isPresent()) {
            System.out.println("not generated");
            return Optional.of(new Booking());
        }
        String pnr = pnrGenerator.getPnr();
        passenger.setPnr(pnr);
        passengerRepository.save(passenger);
        Booking booking= new Booking();
        booking.setFlightNo(flightNo);
        booking.setPnr(pnr);
        booking.setUserEmail(passenger.getBookingMail());
        System.out.println("booking"+" "+passenger.getBookingMail());
        bookingRepository.save(booking);
        return Optional.of(booking);
    }

    public User userRegistration(User user){
        Optional<User> mailCheck = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        Optional<User> phoneCheck=Optional.ofNullable(userRepository.findByPhone(user.getPhone()));
        if (mailCheck.isPresent()||phoneCheck.isPresent())
            return null;
        return userRepository.save(user);
    }

    public Booking findByPnr(@PathVariable(value = "pnr") String pnr){
        return bookingRepository.findByPnr(pnr);
    }

    public List<Booking> findByMail(String emailId){
        return  bookingRepository.findByEmail(emailId);
    }

    public Booking deleteByPnr(String pnr){
        Booking booking = bookingRepository.findByPnr(pnr);
        Passenger passenger= passengerRepository.findByPnr(pnr);
        bookingRepository.delete(booking);
        passengerRepository.delete(passenger);
        return booking;
    }
}
