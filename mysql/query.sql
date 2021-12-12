select * from appointment;
select * from workslot;

INSERT INTO appointment (counter_id, citizen, `date`, startTime, endTime) VALUES (2500,'374580', '2021-12-13-', '09:20', '09:30' );
INSERT INTO appointment (counter_id, citizen, `date`, startTime, endTime) VALUES (2500,'374580', '2021-12-13-', '09:50', '10:00' );

select startTime from appointment where appointment.startTime NOT IN  ( select `time` from workslot );

select `time` from workslot where workslot.`time` NOT IN  ( select startTime from appointment WHERE `date` = '2021-12-13' AND counter_id = 2500 );

select time from workslot left join appointment on workslot.`time` = appointment.startTime where appointment.startTime IS NULL;



