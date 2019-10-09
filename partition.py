# 这个模版需要将pivot点设置在最左边
def partition(nums, start, end):
  left, right = start, end
  pivot = nums[left]
  while left < right:
    while left < right and nums[right] >= pivot:
      right -= 1
    nums[left] = nums[right]
    while left < right and nums[left] <= pivot:
      left += 1
    nums[right] = nums[left]

  nums[left] = pivot
  return left    

def partition(nums, k):
  left, right = start, end
  while left < right:
    while left < right and nums[left] < k:
      left += 1

    while left < right and nums[right] >= k:
      right -= 1

    if left < right:    
      nums[left], nums[right] = nums[right], nums[left]
      left += 1
      right -= 1

  return left    