CREATE DATABASE AtmDB;
CREATE TABLE cards (
    accaumt_id INT PRIMARY KEY AUTO_INCREMENT,
    card_number VARCHAR(16) NOT NULL,
    pincode VARCHAR(3) NOT NULL
);

CREATE TABLE balance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    card_number INT NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (card_id) REFERENCES cards(id)
);

CREATE TABLE account_detail (
    id INT PRIMARY KEY AUTO_INCREMENT,
    card_number INT NOT NULL,
   first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    FOREIGN KEY (card_id) REFERENCES cards(id)
);
