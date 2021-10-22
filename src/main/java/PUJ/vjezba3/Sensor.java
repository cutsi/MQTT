package PUJ.vjezba3;

public class Sensor {
	private short Factor;
	private String Unit;
	private short Min;
	private short Max;
	private String Topic;

	@Override
	public String toString() {
		return "Sensor [Factor=" + Factor + ", Unit=" + Unit + ", Min=" + Min + ", Max=" + Max + ", Topic=" + Topic
				+ "]";
	}

	short GenerateRandomRange() {
		short r = (short) ((short) (Math.random() * (this.Max - this.Min)) + this.Min);
		if (this.Factor != 0) {
			r = (short) (r / this.Factor);
		}
		return r;
	}

	Sensor() {
	}

	Sensor(short factor, String unit, short min, short max, String topic) {
		this.Factor = factor;
		this.Unit = unit;
		this.Min = min;
		this.Max = max;
		this.Topic = topic;
	}

	public short getFactor() {
		return Factor;
	}

	public void setFactor(short factor) {
		Factor = factor;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public short getMin() {
		return Min;
	}

	public void setMin(short min) {
		Min = min;
	}

	public short getMax() {
		return Max;
	}

	public void setMax(short max) {
		Max = max;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

}
