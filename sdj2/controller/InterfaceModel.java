package sdj2.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import SEP1.TheTime;
import sdj2.model.Rent;
import sdj2.model.RentList;
import sdj2.model.VehicleList;


public interface InterfaceModel extends Remote {

	RentList getAll() throws RemoteException;

	void deleteReservation(int resNo) throws RemoteException;
	
	void addObserver(RemoteObserver o) throws RemoteException;

	Rent getRent(int resNo) throws RemoteException;

	VehicleList getAllInInterval(TheTime startDate, TheTime endDate) throws RemoteException;
	
	void saveReservation(Rent reservation) throws RemoteException;
	
}