// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package pusher.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.pusher.rest.Pusher;
import pusher.helpers.PusherFactory;
import pusher.helpers.PusherMessage;
import pusher.proxies.constants.Constants;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Send a refresh command to the provided channel. The object that is send is refreshed by ID, this requires that the client already has knowledge of the object otherwise it cannot be refreshed.
 */
public class RefreshObjectByID extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject AnyObject;
	private java.lang.String Channel;

	public RefreshObjectByID(IContext context, IMendixObject AnyObject, java.lang.String Channel)
	{
		super(context);
		this.AnyObject = AnyObject;
		this.Channel = Channel;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		Pusher pusherObject = PusherFactory.getPusher(Constants.getappId(), Constants.getapiKey(), Constants.getappSecret(),Constants.getcluster());
		pusherObject.trigger(this.Channel, "refresh_object", new PusherMessage(this.AnyObject,this.getContext()));
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "RefreshObjectByID";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}