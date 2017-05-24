package edu.mum.batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;

import edu.mum.domain.TripPayment;

public class CustomItemWriter implements ItemWriter<TripPayment> {

	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public void write(List<? extends TripPayment> tripPayments) throws Exception {
		// TODO Auto-generated method stub

		// check if folder name is base on trip_id if also exist, then add new
		// report file
		// Report format Payment_YYMMDD

		Map<String, StringBuffer> fileContents = new HashMap<String, StringBuffer>();
		// Write content

		tripPayments.forEach(payment -> {

			if (fileContents.containsKey(payment.getTripId())) {
				StringBuffer currentContent = fileContents.get(payment.getTripId());
				currentContent.append(generatContentFile(payment));
				fileContents.put(payment.getTripId(), currentContent);
			} else {
				fileContents.put(payment.getTripId(), new StringBuffer(generatContentFile(payment)));
			}
		});
		// write file base trip folder

		fileContents.forEach((tripId, content) -> {
			writeContentToFile(tripId, content);
		});

	}

	private String generatContentFile(TripPayment payment) {

		return "Trip Id: " + payment.getTripId() + " Date: " + payment.getDate().toString() + " Payment Amout :"
				+ payment.getAmount() + " for " + payment.getDescription() + "\r\n";
	}

	private void writeContentToFile(String tripId, StringBuffer content) {

		String path = location + "/" + tripId;

		FileWriter fw = null;
		BufferedWriter bw = null;

		Path folder = Paths.get(path);
		// if directory exists?
		if (!Files.exists(folder)) {
			try {
				Files.createDirectories(folder);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}

		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);

		String fileName = "Payment_" + date1.toString() + ".txt";
		String info = content.toString();

		File reportFile = new File(path + "/" + fileName);

		try {
			
			if(reportFile.exists()) {
				System.out.println("File is already Existing....................");
				
			}

			if (!reportFile.exists()) {
				reportFile.createNewFile();

				try {
					fw = new FileWriter(reportFile.getAbsoluteFile(), true);
					bw = new BufferedWriter(fw);

					bw.write(info);

					System.out.println(info);

				} catch (IOException e) {

					e.printStackTrace();

				} finally {

					try {
						if (bw != null)
							bw.close();

						if (fw != null)
							fw.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
