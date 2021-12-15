/*
Created		07.09.2020
Modified		03.10.2020
Project
Model
Company
Author
Version
Database		Oracle 8
*/



















Drop table Firm
    /
Drop table Position
    /
Drop table Pearson
    /
Drop table Account
    /
Drop table Operation
    /
Drop table Client
    /
Drop table Employee
    /














Create table Employee
(
    EmployeeID Char(20) NOT NULL  UNIQUE ,
    Wdate Char(20),
    PearsonID Char(20) NOT NULL ,
    PositionId Char(20) NOT NULL
)
    /

Create table Client
(
    ClientID Char(20) NOT NULL  UNIQUE ,
    PasspNum Char(20),
    PearsonID Char(20) NOT NULL
)
    /

Create table Operation
(
    OppNum Char(20) NOT NULL ,
    Date Char(20),
    Type Char(20),
    Summ Char(20),
    EmployeeID Char(20) NOT NULL ,
    AccID Char(20) NOT NULL ,
    PearsonID Char(20) NOT NULL
)
    /

Create table Account
(
    AccID Char(20) NOT NULL ,
    PearsonID Char(20) NOT NULL ,
    FirmID Char(20) NOT NULL ,
    ODate Char(20),
    CDate Char(20),
    Summ Char(20),
    ClientID Char(20) NOT NULL
)
    /

Create table Pearson
(
    PearsonID Char(20) NOT NULL ,
    Name Char(20),
    Bdate Char(20),
    Adress Char(20),
    FirmID Char(20) NOT NULL
)
    /

Create table Position
(
    PositionId Char(20) NOT NULL ,
    Type Char(20)
)
    /

Create table Firm
(
    FirmID Char(20) NOT NULL ,
    Name Char(20)
)
    /



Alter table Employee add primary key (EmployeeID,PearsonID)
    /
Alter table Client add primary key (ClientID,PearsonID)
    /
Alter table Operation add primary key (OppNum)
    /
Alter table Account add primary key (AccID)
    /
Alter table Pearson add primary key (PearsonID)
    /
Alter table Position add primary key (PositionId)
    /
Alter table Firm add primary key (FirmID)
    /












Alter table Operation add  foreign key (EmployeeID,PearsonID) references Employee (EmployeeID,PearsonID)
    /
Alter table Account add  foreign key (ClientID,PearsonID) references Client (ClientID,PearsonID)
    /
Alter table Operation add  foreign key (AccID) references Account (AccID)
    /
Alter table Employee add  foreign key (PearsonID) references Pearson (PearsonID)
    /
Alter table Client add  foreign key (PearsonID) references Pearson (PearsonID)
    /
Alter table Employee add  foreign key (PositionId) references Position (PositionId)
    /
Alter table Pearson add  foreign key (FirmID) references Firm (FirmID)
    /
Alter table Account add  foreign key (FirmID) references Firm (FirmID)
    /






















