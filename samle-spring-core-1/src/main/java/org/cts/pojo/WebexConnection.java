package org.cts.pojo;

public class WebexConnection {
	private String connectionID;

	public WebexConnection() {
		super();
	}

	public WebexConnection(String connectionID) {
		super();
		this.connectionID = connectionID;
	}

	public String getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(String connectionID) {
		this.connectionID = connectionID;
	}

	@Override
	public String toString() {
		return "WebexConnection [connectionID=" + connectionID + "]";
	}

}
