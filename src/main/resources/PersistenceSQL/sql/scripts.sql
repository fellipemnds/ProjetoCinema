/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Gealisson
 * Created: 27 de nov. de 2021
 */
INSERT INTO tbl_filme  VALUES(100,'Timothee Chalamet,Rebecca Ferguson, Oscar Isaac,  Zendaya, Javier Bardem, Stellan Skarsgård.',12,200,'fantasia',FALSE,5,'Paul Atreides e um jovem brilhante, dono de um destino alem de sua compreensao. Ele deve viajar para o planeta mais perigoso do universo para garantir o futuro de seu povo.','Duna');
INSERT INTO tbl_filme  VALUES(102,'Timothee Chalamet',12,250,'fantasia',FALSE,3,'resumo de filme','Duna 2');
INSERT INTO tbl_filme  VALUES(103,'Timothee Chalamet',12,150,'fantasia',FALSE,2,'resumo de filme','Duna 3');
INSERT INTO tbl_filme  VALUES(104,'Stephanie Beatriz',12,109,'animacao',FALSE,4,'Encanto e a nova animação da Disney situada na Colombia, sobre a extraordinaria familia Madrigal, que vive escondida em uma região montanhosa isolada, conhecido como Encanto.','Encanto');
INSERT INTO tbl_filme  VALUES(105,'Angelina Jolie',14,157,'fantasia',FALSE,5,'resumo de filme','Eternos');

INSERT INTO tbl_sessao VALUES(100,'2021-12-13 20:30:00',FALSE,'tipo1',100,null);
INSERT INTO tbl_sessao VALUES(102,'2021-12-14 21:30:00',FALSE,'tipo2',103,null);
INSERT INTO tbl_sessao VALUES(103,'2021-12-15 20:30:00',FALSE,'tipo1',102,null);
INSERT INTO tbl_sessao VALUES(104,'2021-12-25 21:30:00',FALSE,'tipo2',104,null);
INSERT INTO tbl_sessao VALUES(105,'2021-12-26 20:30:00',FALSE,'tipo1',100,null);

INSERT INTO tbl_formas_pagamento VALUES(100,FALSE,'Cartao',10,null,null);

INSERT INTO tbl_cartao VALUES(100,FALSE);