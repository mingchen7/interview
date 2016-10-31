// template 1 : recommend
public int partitionArray(int[] nums, int start, int end, int k) {
    if(nums == null || nums.length == 0){
        return 0;
    }
    
    int pivot = k;
    int i = start;
    for (int j = i; j <= end; j++) {
        if (nums[j] < pivot) {
            swap(nums, i, j);
            i = i + 1;
        }
    }
    
    // in case if k is not in nums
    if (i == nums.length - 1) {
        return i+1;
    }
    // normal situation
    else {
        return i;    
    }
}


// template 2: two pointers
public int partition(int[] nums, int start, int end) {
    int left = start, right = end;
    int pivot = nums[left];

    while (left < right) {
        while (left < right && nums[right] >= pivot) {
            right--;
        }

        nums[left] = nums[right];

        while (left < right && nums[left] <= pivot) {
            left++;
        }

        nums[right] = nums[left];
    }

    nums[left] = pivot;
    // left and right points to same position
    return left;
}

