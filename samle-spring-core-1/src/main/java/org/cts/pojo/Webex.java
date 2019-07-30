/**
 * 
 */
package org.cts.pojo;

/**
 * @author aditya
 *
 */
public class Webex {
	private String webexClient;
	private String webexVesion;

	public Webex() {
		super();
	}

	public Webex(String webexClient, String webexVesion) {
		super();
		this.webexClient = webexClient;
		this.webexVesion = webexVesion;
	}

	public String getWebexClient() {
		return webexClient;
	}

	public void setWebexClient(String webexClient) {
		this.webexClient = webexClient;
	}

	public String getWebexVesion() {
		return webexVesion;
	}

	public void setWebexVesion(String webexVesion) {
		this.webexVesion = webexVesion;
	}

	@Override
	public String toString() {
		return "Webex [webexClient=" + webexClient + ", webexVesion=" + webexVesion + "]";
	}

}
