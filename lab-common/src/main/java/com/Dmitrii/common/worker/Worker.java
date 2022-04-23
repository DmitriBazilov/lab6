package com.Dmitrii.common.worker;

import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.util.Comparator;

/**
 *
 * Непосредственно сам класс раба.
 */
public class Worker implements Comparable<Worker> {

	public static final int COUNTOFSETARGS = 7;

	private Integer id;
	private String name;
	private Coordinates coordinates;
	private ZonedDateTime creationDate;
	private Long salary;
	private LocalDateTime startDate;
	private Position position;
	private Status status;
	private Person person;
	private static int idCounter = 1;

	public Worker() {
		creationDate = ZonedDateTime.now();
	}

	public Worker(String name, Coordinates coordinates, Long salary, LocalDateTime startDate, Position position, Status status, Person person) {
		this.name = name;
		this.coordinates = coordinates;
		this.salary = salary;
		this.startDate = startDate;
		this.position = position;
		this.status = status;
		this.person = person;
		this.creationDate = ZonedDateTime.now();
		this.id = idCounter++;
	}

	public void setId() {
		id = idCounter++;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Long getSalary() {
		return salary;
	}

	public void setStartDate(LocalDateTime date) {
		this.startDate = date;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	} 

	public void initCreationDate() {
		this.creationDate = ZonedDateTime.now();
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setPosition(Position pos) {
		position = pos;
	}

	public Position getPosition() {
		return position;
	}

	public void setStatus(Status s) {
		status = s;
	}

	public Status getStatus() {
		return status;
	}

	public void setPerson(Person p) {
		person = p;
	} 

	public Person getPerson() {
		return person;
	}
	
	@Override
	public int compareTo(Worker w) {
		return Comparator.comparing(Worker::getCoordinates).compare(this, w);
	}

	@Override
	public String toString() {
		return "Worker{" + "id=" + id + ", name=" + name + ", coordinates=" + coordinates + ", creationDate=" + creationDate + ", salary=" + salary + ", startDate=" + startDate + ", position=" + position + ", status=" + status + ", person=" + person + '}';
	}
	
	
}
