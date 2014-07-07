
package org.asha.app.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {
    private String mEventTitle;

    private String mEventDescription;

    private String mEventTime;

    private String mEventLocation;

    public String getEventTitle() {
        return mEventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.mEventTitle = eventTitle;
    }

    public String getEventDescription() {
        return mEventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.mEventDescription = eventDescription;
    }

    public String getEventTime() {
        return mEventTime;
    }

    public void setEventTime(String eventTime) {
        this.mEventTime = eventTime;
    }

    public String getEventLocation() {
        return mEventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.mEventLocation = eventLocation;
    }

    public static Event createMockObject(int index) {
        Event event = new Event();
        event.setEventDescription("Event Description" + index);
        event.setEventLocation("Event Location" + index);
        event.setEventTime("Sun, July 6th 2014");
        event.setEventTitle("Event Title" + index);
        return event;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getEventDescription());
        dest.writeString(getEventLocation());
        dest.writeString(getEventTime());
        dest.writeString(getEventTitle());
    }
}
