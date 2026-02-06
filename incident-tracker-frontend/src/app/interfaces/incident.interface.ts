export interface Incident {
  id?: number;
  title: string;
  description: string;
  priority: 'LOW' | 'NORMAL' | 'HIGH' | 'CRITICAL';
  status: 'OPEN' | 'IN_PROGRESS' | 'RESOLVED' | 'CLOSED';
  createdAt?: string;
  updatedAt?: string;
}

export interface CreateIncidentRequest {
  title: string;
  description: string;
  priority: 'LOW' | 'NORMAL' | 'HIGH' | 'CRITICAL';
}

export interface StatusUpdateRequest {
  status: 'OPEN' | 'IN_PROGRESS' | 'RESOLVED' | 'CLOSED';
}

// Réponse de l'IA pour la classification
export interface IncidentSuggestion {
  priority: 'LOW' | 'NORMAL' | 'HIGH' | 'CRITICAL';
  category: string;
  reasoning: string;
}
