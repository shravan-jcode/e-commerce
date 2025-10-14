import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules

# Sample dataset
data = [['milk','bread','butter'],
        ['milk','bread'],
        ['milk','butter'],
        ['bread','butter'],
        ['milk','bread','butter','cheese'],
        ['milk','cheese']]

# Transform transactions
te = TransactionEncoder()
df = pd.DataFrame(te.fit(data).transform(data), columns=te.columns_)

# Frequent itemsets
freq_items = apriori(df, min_support=0.5, use_colnames=True)

# Association rules
rules = association_rules(freq_items, metric="confidence", min_threshold=0.5)

# Output
print("Frequent Itemsets:\n", freq_items)
print("\nAssociation Rules:\n", rules[['antecedents','consequents','support','confidence','lift']])
