package com.codeWithProject.hotelServer.services.customer.booking;

import com.codeWithProject.hotelServer.dto.ReservationDto;
import com.codeWithProject.hotelServer.dto.ReservationResponseDto;
import com.codeWithProject.hotelServer.entity.Reservation;
import com.codeWithProject.hotelServer.entity.Room;
import com.codeWithProject.hotelServer.entity.User;
import com.codeWithProject.hotelServer.enums.ReservationStatus;
import com.codeWithProject.hotelServer.repository.ReservationRepository;
import com.codeWithProject.hotelServer.repository.RoomRepository;
import com.codeWithProject.hotelServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;          // Repository để tìm kiếm người dùng
    private final RoomRepository roomRepository;          // Repository để tìm kiếm phòng
    private final ReservationRepository reservationRepository; // Repository để lưu đặt phòng
    private static final int SEARCH_RESULT_PER_PAGE =4;
    public boolean postReservation(ReservationDto reservationDto) {
        // Tìm người dùng và phòng từ ID
        Optional<User> optionalUser = userRepository.findById(reservationDto.getUserId());
        Optional<Room> optionalRoom = roomRepository.findById(reservationDto.getRoomId());

        // Kiểm tra xem người dùng và phòng có tồn tại không
        if (optionalRoom.isPresent() && optionalUser.isPresent()) {
            Reservation reservation = new Reservation();

            // Lấy ngày nhận và trả phòng từ đối tượng reservationDto
            reservation.setCheckInDate(reservationDto.getCheckInDate());
            reservation.setCheckOutDate(reservationDto.getCheckOutDate());

            // Gán phòng và người dùng vào đối tượng đặt phòng
            reservation.setRoom(optionalRoom.get());
            reservation.setUser(optionalUser.get());


            // Đặt trạng thái đặt phòng
            reservation.setReservationStatus(ReservationStatus.FENDING);

            // Tính số ngày giữa ngày nhận và trả phòng
            Long days = ChronoUnit.DAYS.between(reservationDto.getCheckInDate(), reservationDto.getCheckOutDate());
            reservation.setPrice(optionalRoom.get().getPrice() * days); // Tính giá dựa trên số ngày

            // Lưu đối tượng đặt phòng vào cơ sở dữ liệu
            reservationRepository.save(reservation);
            return true; // Trả về true nếu đặt phòng thành công
        }
        return false; // Trả về false nếu không tìm thấy người dùng hoặc phòng
    }
    public ReservationResponseDto getAllReservationByUserId(Long userId, int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,SEARCH_RESULT_PER_PAGE);
        Page<Reservation> reservationPage = reservationRepository.findAllByUserId(pageable,userId);
        ReservationResponseDto reservationResponseDto = new ReservationResponseDto();
        reservationResponseDto.setReservationDtoList(reservationPage.stream().map(Reservation::getReservationDto)
                .collect(Collectors.toList()));
        reservationResponseDto.setPageNumber(reservationPage.getPageable().getPageNumber());
        reservationResponseDto.setTotalPage(reservationPage.getTotalPages());
        return  reservationResponseDto;
    }
}
