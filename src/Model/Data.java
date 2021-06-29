package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

public class Data implements Iterable<String> {

	private RandomAccessFile dIn;

	public Data(RandomAccessFile dIn) {
		this.dIn = dIn;
	}

	@Override
	public Iterator<String> iterator() {
		return new MyIterator(dIn);
	}

	public class MyIterator implements Iterator<String> {
		// private File file;
		private long curPointer;
		private long lastPointer;
		private long deletePointer;
		private RandomAccessFile dIn;
		private int counter;
		private String str;

		public MyIterator(RandomAccessFile dIn) {
			this.dIn = dIn;
			this.curPointer = 0;
			this.lastPointer = 0;
			this.counter = 0;

		}

		@Override
		public boolean hasNext() { // there is next
			try {
				long ret = dIn.length() - dIn.getFilePointer();
				if (ret > 0)
					return true;
			} catch (IOException e) {
				return false;
			}
			return false;
		}

		@Override
		public String next() {
			try {
				if (hasNext()) {
					curPointer = dIn.getFilePointer();
					if (counter % 7 == 0) {
						deletePointer = lastPointer;
						lastPointer = curPointer;
						// counter = 0;
						// System.out.println("cur= " + curPointer + " last= " +lastPointer + " del= "+
						// deletePointer + " counter= "+ counter);
					}
					counter++;
					str = dIn.readUTF();
					return str;
				}
			} catch (IOException e) {
				return null;
			}
			return null;
		}

		@Override
		public void remove() {// remove from
			try {
				curPointer = dIn.getFilePointer();
				deletePointer = lastPointer;
				lastPointer = curPointer;
				// System.out.println("cur= " + curPointer + " last= " +lastPointer + " del= "+
				// deletePointer + " counter= "+ counter);
				byte[] dataRight = new byte[(int) (dIn.length() - lastPointer)];
				System.out.println((new String(dataRight)));
				dIn.read(dataRight); // fill dataRight with bytes from the right side of the word
				dIn.setLength(deletePointer);// delet all of them and the "find" and set length to raf
				dIn.seek(deletePointer);
				dIn.write(dataRight);// write the rest of the file without the "find"
			} catch (IOException e) {
			}

		}
	}
}

/*
 * public boolean addMakatAndProduct(Product pro, String makat) throws
 * IOException { while (hasNext()) { dIn.seek(2);// after the sort option and
 * how many products there are String makat1 = next();// read the first string ,
 * need to be the first makat if (makat.compareTo(makat1) < 0) { byte[]
 * dataRight = new byte[(int) (dIn.length() - lastPointer + 2)]; // space of the
 * rest of the file to fill with bytes from the file dIn.read(dataRight); //
 * read the rest of the file to the data right dIn.setLength(lastPointer);// cut
 * the file to there dIn.seek(lastPointer);// set the pointer to there
 * dIn.writeUTF(makat);// write the makat pro.writeProductToTheFile(dIn,
 * this);// write the product dIn.write(dataRight);// write what we copy before
 * return true; } for (int i = 0; i < 6; i++) { // run 6 times and update the
 * itartor cuz now we read the product and then we // want again to read makat
 * if (!hasNext()) return false; next(); } } dIn.writeUTF(makat);// write to the
 * end of the file the makat pro.writeProductToTheFile(dIn, this);// now write
 * the product return true; }
 */
