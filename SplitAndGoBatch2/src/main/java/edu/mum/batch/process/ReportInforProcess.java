package edu.mum.batch.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

import edu.mum.domain.TripPayment;

public class ReportInforProcess implements ItemProcessor<TripPayment, TripPayment> {

	private String location;

	@Override
	public TripPayment process(TripPayment tripPayment) throws Exception {
		// TODO Auto-generated method stub

		// check if folder name is base on trip_id if also exist, then add new
		// report file
		// Report format Payment_YYMMDD
		String path = location + "/" + tripPayment.getTripId();

		Path folder = Paths.get(path);
        //if directory exists?
        if (!Files.exists(folder)) {
            try {
                Files.createDirectories(folder);
            } catch (IOException e) {
                //fail to create directory
                e.printStackTrace();
            }
        }

		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);

		// Write content
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String fileName = "Payment_" + date1.toString() + ".txt";
			String content = generatContentFile(tripPayment);

			File reportFile = new File(path + "/" + fileName);

			if (!reportFile.exists()) {
				reportFile.createNewFile();
				// true = append file
			}

			fw = new FileWriter(reportFile.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(content);

			System.out.println(content);
			
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

		return tripPayment;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private String generatContentFile(TripPayment payment) {

		return "Trip Id: " + payment.getTripId() + " Date: " + payment.getDate().toString() + " Payment Amout :"
				+ payment.getAmount() + " for " + payment.getDescription() + "\r\n";
	}
}
