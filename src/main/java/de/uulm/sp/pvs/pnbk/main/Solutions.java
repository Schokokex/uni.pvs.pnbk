package de.uulm.sp.pvs.pnbk.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import de.uulm.sp.Zoo.animals.*;
import de.uulm.sp.Zoo.containers.*;

public class Solutions {

	// @formatter:off

	/**
	 * 3p Writes the contents from all files at the passed paths to the output file
	 * (create if not existent) by bytewise alternating between the files
	 * 
	 * sample: f1: abc; f2: abc -> outputFile: aabbcc f1: abcd; f2: e; f3: f ->
	 * outputfile: aefbcd
	 * 
	 * @param outputPath path of file to write to
	 * @param paths      paths of files to read from
	 * @throws Exception
	 */
	public static void combineFileContents(String outputPath, String... paths) throws Exception {
		final var outFile = new FileOutputStream(outputPath);
		final var amntInpFiles = paths.length;
		final var inFileStreams = new FileInputStream[amntInpFiles];
		for (int i = amntInpFiles - 1; i >= 0; i--) {
			inFileStreams[i] = new FileInputStream(paths[i]);
		}

		for (boolean allDone = true;; allDone = true) {
			for (int i = 0; i < amntInpFiles; i++) {
				final var a = inFileStreams[i].readNBytes(1);
				outFile.write(a);
				if (a.length > 0) {
					allDone = false;
				} else {
					inFileStreams[i].close();
				}
			}
			if (allDone) {
				break;
			}
		}
		outFile.close();
	}

	/**
	 * find overlaps (in sorted order) of n intervals with variable stepWidth input
	 * format: (start,end,stepWidth);...
	 * 
	 * output format: [overlap1, ...] whitespace is ignored in the output!!
	 * 
	 * sample: "(1,100,1);(0,100,2)" -> [all even numbers]
	 * "(44,44,1);(40,50,2);(1,1,1)" -> "[1, 44]"
	 * 
	 * @param s in input format
	 * @return String in output format
	 * @throws Exception
	 */
	public static String overlaps(String s) throws Exception {
		// TODO
		return "";
	}

	/**
	 * highlight all tiles that are reached by at least one light source input
	 * format: eeee eswe eeee e = empty tile s = light source w = wall l = lit tile
	 * 
	 * light source can reach a total of two tiles away in each direction (as a
	 * square): eeeeeee ellllle ellllle ellslle ellllle ellllle eeeeeee
	 * 
	 * walls block tiles behind them eewsll
	 * 
	 * eelll ewlll llsll lllwe lllee
	 * 
	 * sample: "eesee" -> "llsll"
	 * 
	 * "eeeee\newewe\neesee\newewe\neeeee" -> "eelee\newlwe\nllsll\newlwe\neelee"
	 * 
	 * @param s in input format
	 * @return String in output format
	 * @throws Exception
	 */
	public static String lightenUp(String s) throws Exception {
		// TODO
		return "";
	}

	/**
	 * find all possible pairs of flight paths for two passengers that do not cross
	 * at all with a maximum of n hops between start and end a hop is defined as A-B
	 * so: A-B + B-C are two hops
	 * 
	 * output format: [([(Start : Between),(Between : End)],[(Start : End)]),...]
	 * whitespace is ignored in the output!!
	 * 
	 * sample: "Frankfurt,Berlin,Warschau,Stuttgart,5" ->
	 * "(Frankfurt->München->Warschau,Berlin->Stuttgart)"
	 * "Frankfurt,Berlin,Brüssel,Stuttgart,2" ->
	 * "(Frankfurt->Wien->Brüssel,Berlin->Stuttgart)
	 * (Frankfurt->Paris->Brüssel,Berlin->Stuttgart)
	 * (Frankfurt->Wien->Brüssel,Berlin->München->Stuttgart)
	 * (Frankfurt->Paris->Brüssel,Berlin->München->Stuttgart)"
	 * 
	 * @param p1Start start airport for passenger 1
	 * @param p2Start start airport for passenger 2
	 * @param p1End   goal airport for passenger 1
	 * @param p2End   goal airport for passenger 2
	 * @param maxHops max number of flights
	 * @return String in output format
	 * @throws Exception
	 */
	public static String socialDistancing(String p1Start, String p2Start, String p1End, String p2End, int maxHops)
			throws Exception {
		// TODO
		return "";
	}

	/**
	 * takes an Animal object from the input stream, converts it into json format
	 * and outputs the string using the outputStream whitespace in the output is
	 * ignored!
	 * 
	 * @param in  Stream transferring *exactly* one animal object
	 * @param out Stream to write Jsonified animal to
	 * @throws Exception
	 */
	public static void jsonifyAnimal(ObjectInputStream in, OutputStream out) throws Exception {
		// TODO
	}

	/**
	 * reads String from input stream and converts it into a penguin object you can
	 * assume that all byte transfered by the input stream together form the string
	 * to use the input will not contain whitespace or line breaks!!
	 * 
	 * @param in  stream transferring the input json String
	 * @param out stream to write Penguin object to
	 * @throws Exception
	 */
	public static void deJsonifyPenguin(InputStream in, ObjectOutputStream out) throws Exception {
		// TODO
	}

	/**
	 * takes a zoo object from the input stream, converts it into json format and
	 * outputs the string using the outputStream whitespace in the output is
	 * ignored!
	 * 
	 * @param in  Stream transferring *exactly* one zoo object
	 * @param out Stream to write Jsonified zoo to
	 * @throws Exception
	 */
	public static void jsonifyZoo(ObjectInputStream in, OutputStream out) throws Exception {
		// TODO
	}

	/**
	 * reads String from input stream and converts it into a zoo object the input
	 * will not contain whitespace or line breaks!! you can assume that all byte
	 * transfered by the input stream together form the string to use
	 * 
	 * @param in  stream transferring the input json String
	 * @param out stream to write Zoo object to
	 * @throws Exception
	 */
	public static void deJsonifyZoo(InputStream in, ObjectOutputStream out) throws Exception {
		// TODO
	}

}