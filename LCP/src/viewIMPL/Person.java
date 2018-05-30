package viewIMPL;

import view.IPerson;

public class Person extends Displayable implements IPerson {

	private String nameOfPerson;

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

}
