//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
   int maxMeetings(int start[], int end[], int n)
{
    // Create a vector of pairs, where each pair represents the end time and start time of a meeting.
    pair<int, int> meetings[n];
    for (int i = 0; i < n; i++)
        meetings[i] = make_pair(end[i], start[i]);

    // Sort the vector of pairs based on the end times of meetings in ascending order.
    sort(meetings, meetings + n);

    int x = 0;  // Variable to store the end time of the last selected meeting.
    int ans = 0;  // Variable to store the count of selected meetings.

    // Iterate through the sorted meetings.
    for (int i = 0; i < n; i++) {
        // If the start time of the current meeting is greater than or equal to the end time of the last selected meeting,
        // then select the current meeting and update the end time variable.
        if (meetings[i].second > x) {
            ans++;
            x = meetings[i].first;
        }
    }

    // Return the count of selected meetings.
    return ans;
}
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int start[n], end[n];
        for (int i = 0; i < n; i++) cin >> start[i];

        for (int i = 0; i < n; i++) cin >> end[i];

        Solution ob;
        int ans = ob.maxMeetings(start, end, n);
        cout << ans << endl;
    }
    return 0;
}
// } Driver Code Ends