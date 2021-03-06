package element;

import java.awt.Color;

import command.AskBuyCommand;
import util.BuildingHolder;
import util.RentCalculator;
import behaviour.ConstructionAllowance;


public class ColoredLand extends PropertyLand {
	
	private BuildingHolder buildingHolder;
	private Color color;
	private int housePrice;
	
	public ColoredLand(String name, Color color, int price, int housePrice, Rent rent) {
		super(name, price, rent);
		this.housePrice = housePrice;
		setColor(color);
		setConstructionBehavior(ConstructionAllowance.CONSTRUCTION_ALLOWED);
		initilizeBuildingHolder();
		setAssignment(new AskBuyCommand());
	}

	private void setColor(Color color) {
		this.color = color;
	}

	private void initilizeBuildingHolder() {
		buildingHolder = new BuildingHolder();		
	}

	public BuildingHolder getBuildingHolder() {
		return buildingHolder;
	}
	
	public Color getColor() {
		return color;
	}

	public int getHousePrice() {
		return housePrice;
	}

	public int getHotelPrice() {
		return housePrice * 5;
	}

	@Override
	public int acceptCalculator(RentCalculator calculator) {
		return calculator.calculate(this);
	}

}
