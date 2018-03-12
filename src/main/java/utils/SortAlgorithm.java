package utils;

import java.util.Random;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年8月3日       八大排序算法解析
 * </pre>
 */
public class SortAlgorithm {

	private static Random random = new Random(47);

	/**
	 * <li>
	 * 内部排序-插入排序-直接插入排序。设立哨兵，作为临时存储和判断数组边界之用。</li> <li>
	 * 稳定排序</li> <li>
	 * 时间复杂度为 O(n^2) 最好O(n)</li>
	 * 
	 * @author liuzhicheng
	 * @date 2017年8月3日 上午11:36:29
	 * @param numbers
	 */
	public static void insertSort(int[] numbers) {
		// 1.从第二个数进行取值，与前面的数进行比较
		for (int i = 1; i < numbers.length; i++) {
			// 若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
			if (numbers[i] < numbers[i - 1]) {
				int j = i - 1;
				// 复制为哨兵，即存储待排序元素
				int temp = numbers[i];
				// 查找在有序表的插入位置
				while (j >= 0 && temp < numbers[j]) {
					numbers[j + 1] = numbers[j];
					// 元素后移
					j--;
				}
				numbers[j + 1] = temp;
			}
		}
	}

	/**
	 * 快速排序
	 * <ul>
	 * <li>从数列中挑出一个元素，称为“基准”</li>
	 * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
	 * 该基准是它的最后位置。这个称为分割（partition）操作。</li>
	 * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>
	 * 时间复杂度：O(nlog2n) 非稳定排序
	 * </ul>
	 * 
	 * @author liuzhicheng
	 * @date 2017年8月3日 下午3:27:50
	 * @param numbers
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			// 选定一个基准值
			int base = numbers[low];
			int i = low, j = high;
			do {
				// 挑选出大于base的值的下标
				while ((numbers[i] < base) && (i < high))
					i++;
				// 挑选出小于base的值的下标
				while ((numbers[j] > base) && (j > low))
					j--;
				if (i <= j) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
					i++;
					j--;
				}
			} while (i <= j);
			if (low < j) {
				quickSort(numbers, low, j);
			}
			if (high > i) {
				quickSort(numbers, i, high);
			}
		}
	}

	/**
	 * <p>
	 * 快速排序 改进
	 * <li>
	 * 在本改进算法中,只对长度大于k的子序列递归调用快速排序,让原序列基本有序，然后再对整个基本有序序列用插入排序算法排序。实践证明，
	 * 改进后的算法时间复杂度有所降低，且当k取值为 8 左右时,改进算法的性能最佳。</li>
	 * </p>
	 * 
	 * @author liuzhicheng
	 * @date 2017年8月4日 上午11:18:57
	 * @param numbers
	 * @param low
	 * @param high
	 * @param k
	 */
	public static void quickSortImprove(int[] numbers, int low, int high, int k) {
		// 长度大于k时递归, k为指定的数 否则调用插入排序
		if (high - low > k) {
			int privot = partition(numbers, low, high);
			quickSortImprove(numbers, low, privot - 1, k);
			quickSortImprove(numbers, privot + 1, high, k);
		} else {
			insertSort(numbers);
		}
	}

	private static int partition(int[] numbers, int low, int high) {
		int privotKey = numbers[low];
		while (low < high) {
			// 先从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
			while ((low < high) && numbers[high] >= privotKey) {
				--high;
			}
			int temp = numbers[low];
			numbers[low] = numbers[high];
			numbers[high] = temp;
			while ((low < high) && numbers[low] <= privotKey) {
				++low;
			}
			int temp1 = numbers[low];
			numbers[low] = numbers[high];
			numbers[high] = temp1;
		}
		return low;
	}
	/**
	 * <p>
	 * 内部排序-交换排序-冒泡排序 时间复杂度O(n^2) 稳定排序
	 * <li>
	 * 利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) , 从而使排序趟数几乎减少了一半。</li>
	 * </p>
	 * 
	 * @author liuzhicheng
	 * @date 2017年8月3日 上午11:33:25
	 * @param args
	 */
	public static void bubbleSort(int[] numbers) {
		int low = 0;
		int high = numbers.length - 1; // 设置变量的初始值
		int tmp;
		int j;
		while (low < high) {
			for (j = low; j < high; ++j) { // 正向冒泡,找到最大者
				if (numbers[j] > numbers[j + 1]) {
					tmp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tmp;
				}
			}
			--high; // 修改high值, 前移一位
			for (j = high; j > low; --j) { // 反向冒泡,找到最小者
				if (numbers[j] < numbers[j - 1]) {
					tmp = numbers[j];
					numbers[j] = numbers[j - 1];
					numbers[j - 1] = tmp;
				}
			}
			++low; // 修改low值,后移一位
		}
	}

	/**
	 * <p>
	 * 内部排序-归并排序
	 * </p>
	 * <li>归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
	 * 然后再把有序子序列合并为整体有序序列。</li>
	 * 
	 * @author liuzhicheng
	 * @date 2017年8月4日 上午11:27:11
	 * @param src
	 * @param dest
	 * @param low
	 * @param high
	 * @param off
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
		int length = high - low;

		// 插入排序
		if (length < 7) {
			for (int i = low; i < high; i++)
				for (int j = i; j > low && ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
					swap(dest, j, j - 1);
			return;
		}

		// Recursively sort halves of dest into src
		int destLow = low;
		int destHigh = high;
		low += off;
		high += off;
		int mid = (low + high) >>> 1;
		mergeSort(dest, src, low, mid, -off);
		mergeSort(dest, src, mid, high, -off);

		// If list is already sorted, just copy from src to dest. This is an
		// optimization that results in faster sorts for nearly ordered lists.
		if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
			System.arraycopy(src, low, dest, destLow, length);
			return;
		}

		// Merge sorted halves (now in src) into dest
		for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
			if (q >= high || p < mid && ((Comparable) src[p]).compareTo(src[q]) <= 0)
				dest[i] = src[p++];
			else
				dest[i] = src[q++];
		}
	}

	private static void swap(Object[] x, int a, int b) {
		Object t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

	public static void main(String[] args) {
		int count = 10;
		Integer[] numbers = new Integer[count];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10000);
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();

		Integer[] destNumber = numbers.clone();
		SortAlgorithm.mergeSort(numbers, destNumber, 0, numbers.length, 0);
		for (int i = 0; i < destNumber.length; i++) {
			System.out.print(destNumber[i] + " ");
		}
	}
}
