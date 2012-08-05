# Sports Tracker GPX Time(Zone) Fix

This Scala application normalises GPX time data exported from [Sports Tracker][SportsTracker] to UTC.

A bit of playing around with Scala. In the process of moving workout data from [Sports Tracker][SportsTracker] 
to [Strava][Strava] it seemed like Sports Tracker file export was not complying with GPX time format and
was not keeping timezone in UTC, so on import into [Strava][Strava], timing was out.

## Note

* Application assumes the timezone of the JVM it's running on as the source timezone and will normalise the time to UTC from there

[SportsTracker]: http://www.sports-tracker.com/  "Sports Tracker"
[Strava]: http://app.strava.com/  "Strava"