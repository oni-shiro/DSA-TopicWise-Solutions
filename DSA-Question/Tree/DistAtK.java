package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class DistAtK {
    private Map<TreeNode,TreeNode> getParent(TreeNode root){
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode parent = q.poll();
                if(parent.left!=null){
                    q.offer(parent.left);
                    parentMap.put(parent.left,parent);
                }
                if(parent.right!=null){
                    q.offer(parent.right);
                    parentMap.put(parent.right,parent);
                }
            }
        }
        
        return parentMap;
    }

    private List<Integer> radialTraversal(TreeNode node, int k, Map<TreeNode,TreeNode> parentMap){
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        q.offer(node);
        set.add(node);
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist==k){
                break;
            }
            while(size-->0){
                TreeNode curr = q.poll();
                
                if(curr.left!=null && !set.contains(curr.left)){
                    q.offer(curr.left);
                    set.add(curr.left);
                }
                if(curr.right!=null && !set.contains(curr.right)){
                    q.offer(curr.right);
                    set.add(curr.right);
                }
                if(parentMap.get(curr)!=null && !set.contains(parentMap.get(curr))){
                    q.offer(parentMap.get(curr));
                    set.add(parentMap.get(curr));
                }
            }
            dist++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       
        Map<TreeNode,TreeNode> parentMap = getParent(root);
       
        return radialTraversal(target,k,parentMap);
    }
}
