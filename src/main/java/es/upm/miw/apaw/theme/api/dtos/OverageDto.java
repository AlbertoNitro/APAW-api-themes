package es.upm.miw.apaw.theme.api.dtos;

public class OverageDto {
	private double overage;

	public OverageDto(double overage) {
		this.setOverage(overage);
	}

	public double getOverage() {
		return overage;
	}

	public void setOverage(double overage) {
		this.overage = overage;
	}

	@Override
	public String toString() {
		return "{\"overage\":" + overage + "}";
	}

}