package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.model.Calendar;
import com.example.holistitimeapi.model.CalendarRepository;
import com.example.holistitimeapi.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SqlCalendarRepository extends CalendarRepository, JpaRepository<Calendar, Integer> {
}
