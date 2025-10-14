from sklearn.datasets import load_breast_cancer
import matplotlib.pyplot as plt
from sklearn.inspection import DecisionBoundaryDisplay
from sklearn.svm import SVC

# Load dataset
cancer = load_breast_cancer()
X = cancer.data[:, :2]  # use first two features for visualization
y = cancer.target

# Train SVM model with RBF kernel
svm = SVC(kernel="rbf", gamma=0.05, C=1.0)
svm.fit(X, y)

# Visualize decision boundary
DecisionBoundaryDisplay.from_estimator(
    svm, 
    X,
    response_method="predict",
    cmap=plt.cm.Spectral,
    alpha=0.8,
    xlabel=cancer.feature_names[0],
    ylabel=cancer.feature_names[1],
)

# Scatter plot of data points
plt.scatter(X[:, 0], X[:, 1], 
            c=y, 
            s=20, 
            edgecolors="k")
plt.title("SVM Decision Boundary on Breast Cancer Dataset")
plt.show()
