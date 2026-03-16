Use Case 1: Room Inventory Setup & Management

Description:
This module manages hotel room inventory.
It stores room types, their availability counts, and pricing information.

Data Structures Used:

HashMap<String, Integer>  → room type → available count

HashMap<String, Double>   → room type → price per night

Key Concepts:

Fast lookup using HashMap

Centralized room inventory

Dynamic updates

Features:


Initialize room types (Single, Double, Suite)

Store room counts

Store room prices

Update room inventory dynamically

Display current inventory


Flow:

Admin adds room type

        ↓
        
Store in HashMap

        ↓
        
Update count / price

        ↓
        
Display inventory


Benefits:

O(1) lookup time

Clean inventory management

Easy to extend for new room types
