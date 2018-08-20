package modelIMPL;

import model.IPerson;
import model.IRoom;

public class Person extends Displayable implements IPerson {

	private String nameOfPerson;
	private IRoom room;

	public Person() {
		super();
	}

	@Override
	public void setName(String newName) {
		this.nameOfPerson = newName;
	}

	@Override
	public String getName() {
		return this.nameOfPerson;
	}

	@Override
	public IRoom getRoom() {
		return room;
	}

	@Override
	public void setRoom(IRoom room) {
		this.room = room;
	}

}
