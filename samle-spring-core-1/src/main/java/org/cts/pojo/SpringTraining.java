package org.cts.pojo;

public class SpringTraining {
	private String trainingName;
	private String trainer;
	private long noOfTrainees;
	private Webex webex;

	public SpringTraining() {
		super();
	}

	public SpringTraining(String trainingName, String trainer, long noOfTrainees) {
		super();
		this.trainingName = trainingName;
		this.trainer = trainer;
		this.noOfTrainees = noOfTrainees;
	}

	public SpringTraining(String trainingName, String trainer, long noOfTrainees, Webex webex) {
		super();
		this.trainingName = trainingName;
		this.trainer = trainer;
		this.noOfTrainees = noOfTrainees;
		this.webex = webex;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public long getNoOfTrainees() {
		return noOfTrainees;
	}

	public void setNoOfTrainees(long noOfTrainees) {
		this.noOfTrainees = noOfTrainees;
	}

	public Webex getWebex() {
		return webex;
	}

	public void setWebex(Webex webex) {
		this.webex = webex;
	}

	@Override
	public String toString() {
		return "SpringTraining [trainingName=" + trainingName + ", trainer=" + trainer + ", noOfTrainees="
				+ noOfTrainees + ", webex=" + webex + "]";
	}

}
