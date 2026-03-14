class NumArray {
    int[] seg;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        seg = new int[4 * n];
        build(0, 0, n - 1);
    }

    public void build(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * idx + 1, l, mid);
        build(2 * idx + 2, mid + 1, r);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public void update(int index, int val) {
        updateHelper(0, 0, n - 1, index, val);
    }

    public void updateHelper(int idx, int l, int r, int index, int val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid)
            updateHelper(2 * idx + 1, l, mid, index, val);
        else
            updateHelper(2 * idx + 2, mid + 1, r, index, val);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    public int query(int idx, int l, int r, int left, int right) {
        if (r < left || l > right)
            return 0;

        if (left <= l && r <= right)
            return seg[idx];

        int mid = l + (r - l) / 2;

        int lc = query(2 * idx + 1, l, mid, left, right);
        int rc = query(2 * idx + 2, mid + 1, r, left, right);

        return lc + rc;
    }
}