class MergeSort
{
        public static int[] sort(int arr[],int start, int end)
        {
                if(start == end)
                {
                        return new int[] {arr[start]};
                }
 
                int mid = start+((end-start)/2);
                int[] nums1 = sort(arr,start, mid);
                int[] nums2 = sort(arr, mid+1, end);
                int[] answer = new int[nums1.length+nums2.length];
                int i=0, apointer = 0, bpointer = 0;
                while(i<(nums1.length + nums2.length))
                { 
                        if(apointer >= nums1.length)
                        {
                                answer[i] = nums2[bpointer++];
                        }
                        else if(bpointer >= nums2.length)
                        {
                                answer[i] = nums1[apointer++];
                        }
                        else if(nums1[apointer] > nums2[bpointer])
                        {
                                answer[i] = nums2[bpointer++];
                        }
                        else
                        {
                                answer[i] = nums1[apointer++];
                        }
                        i++;
                }
                return answer;
        }
}
