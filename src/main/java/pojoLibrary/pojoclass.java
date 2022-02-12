package pojoLibrary;

public class pojoclass {

	public String createdBy;
	public String projectName;
	public String status;
	public int teamsize;

	public pojoclass(String createdBy, String projectName, String status, int teamsize ) {
		super();
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamsize = teamsize;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getStatus() {
		return status;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	
	
	
	
	
	
}
