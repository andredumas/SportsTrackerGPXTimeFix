# Sports Tracker GPX Time(Zone) Fix

This Scala application normalises [GPX][GPX] time data exported from [Sports Tracker][SportsTracker] to UTC.

In the process of moving workout data from [Sports Tracker][SportsTracker] 
to [Strava][Strava], I found that [Sports Tracker][SportsTracker] file export was not keeping times exported relative to UTC, 
so on import into [Strava][Strava] timings were incorrect for my timezone.

This was written in Scala to play around with regex in Scala. 

## Note

* Application assumes the timezone of the JVM it's running on as the source timezone and will normalise the time to UTC from there

[SportsTracker]: http://www.sports-tracker.com/  "Sports Tracker"
[Strava]: http://app.strava.com/  "Strava"
[GPX]: http://www.topografix.com/gpx.asp "GPX"