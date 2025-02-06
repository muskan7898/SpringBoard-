## Apis description

### Vehicle booking details api
Create a get api like

`/vehicle/{vehicleId}/booking-details which returns the following data for a vehicle if found`

```java
class VehicleBookingResponse {

	// here date are in timestamp string
	public static class BookingDetails {
		private String startDate;
		private String endDate;
	}

	private String model;
	private int manufactureYear;
	private VehicleStatus status;
	private String vehicleType;
	private List<BookingDetails> bookingList;
}
```

