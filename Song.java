public class Song {
    int binarySearch(int arr[], int key) 
	
    { 
		int start = 0, len = arr.length - 1; 
		while (start <= len) { 
			int midpoint = start + (len - start) / 2; 
			
            if (arr[midpoint] == key) 
				return midpoint; 

			if (arr[midpoint] < key) 
				start = midpoint + 1;  
			
            else
				len = midpoint - 1; 
		} 

		return -1; 
	}     
}
