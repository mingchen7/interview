def sift_up(id):
  while (parent(id) > -1):
    parent_id = parent(id)
    if heap.get(parent_id) < heap.get(id):
      break
    else:
      swap(id, parent_id)
    id = parent_id    

def sift_down(id):
  while lson(id) < heap.size():
    left_id = lson(id)
    right_id = rson(id)
    if right_id > heap.size() or heap.get(left_id) < heap.get(right_id):
      son = left_id
    else:
      son = right_id

    if heap.get(id) < heap.get(son):
      break
    else:
      swap(id, son)
    id = son