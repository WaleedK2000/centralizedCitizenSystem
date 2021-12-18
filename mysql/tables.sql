
CREATE TABLE workslot (
	`time` TIME(0) not null primary key
);

CREATE PROCEDURE populateWorkslot()
BEGIN
	SET @x = 0;
    WHILE @x < 1024 DO
    INSERT INTO workslot VALUES (@x);
    
    
    
CREATE PROCEDURE CreateEntry(
	DECLARE @StartTime time '09:00' 
    @Mins int 0
    )
    AS
    BEGIN
    
    

CREATE TABLE appointment  (

	counter_id int not null,
	citizen varchar(10) NOT NULL,
    `date` date not null,
    startTime TIME(0) not null,
    endTime TIME(0) not null,
    
    constraint primary key (counter_id, `date`, startTime),
    
    CONSTRAINT mustEndAfterStart CHECK (
        endTime > startTime
    )
);


CREATE TABLE citizen (

	cnic VARCHAR(10) NOT NULL,
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	dob DATE NOT NULL,
	gender VARCHAR(1), NOT NULL

);

