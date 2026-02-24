class Solution {
    static class DSU {
        Map<String, String> parent = new HashMap<>();
        
        String find(String email) {
            parent.putIfAbsent(email, email);
            if (!parent.get(email).equals(email)) {
                parent.put(email, find(parent.get(email)));
            }
            return parent.get(email);
        }

  
        void union(String email1, String email2) {
            String p1 = find(email1);
            String p2 = find(email2);
            if (!p1.equals(p2)) {
                parent.put(p1, p2);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();

     
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
             
                dsu.union(account.get(1), email);
            }
        }

   
        Map<String, TreeSet<String>> parentToEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String parentEmail = dsu.find(email);
            parentToEmails.putIfAbsent(parentEmail, new TreeSet<>());
            parentToEmails.get(parentEmail).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (String parentEmail : parentToEmails.keySet()) {
            List<String> mergedAccount = new ArrayList<>();
            String name = emailToName.get(parentEmail);
            mergedAccount.add(name);
            mergedAccount.addAll(parentToEmails.get(parentEmail));
            result.add(mergedAccount);
        }

        return result;
    }
}